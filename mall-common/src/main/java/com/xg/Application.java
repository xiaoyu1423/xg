package com.xg;

import com.xg.control.config.WebConfig;
import com.xg.mall.order.jms.ReceiveTask;
import com.xg.redis.RedisDB;
import com.xg.redis.RedisString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Import({WebConfig.class, ReceiveTask.class})
@EnableScheduling
@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration
@RestController
// 启用AOP注解特性
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
@Configuration
public class Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(Application.class, args);


		RedisString.set("test", "KO!", RedisDB.DB_INDEX_01);
		String test = RedisString.get("test", RedisDB.DB_INDEX_01);
		System.out.println("*************************************************************************************");
		System.out.println("test : " + test);
		System.out.println("*************************************************************************************");
	}

	@RequestMapping("/")
	public String index() {
		return "欢迎光临!";
	}

	@Bean(name = "ReceiveTask")
	public ReceiveTask generateDemo() {
		ReceiveTask demo = new ReceiveTask();
		return demo;
	}

	/**
	 * 主板 华硕（ASUS）PRIME Z370-P 主板（Intel Z370/LGA 1151）	1300(直购)
	 * CPU 英特尔（Intel） i7 8700K 酷睿六核 盒装CPU处理器	433.17(分6期) 待还款 2166
	 * 电源 长城（GreatWall）额定500W 双卡王GW-6000冲锋版 电源（背板走线/主动式PFC/12cm静音风扇/智能温控）	300（直购）
	 * 固态 金士顿(Kingston)A400系列 240G SATA3 固态硬盘 400（直购）
	 * 内存 金士顿(Kingston)骇客神条 Fury系列 DDR4 2400 8G 台式机内存	629（直购）
	 * 		金士顿(Kingston)骇客神条 Fury系列 DDR4 2400 16G 台式机内存	1269（直购） 待定
	 * 显卡 七彩虹(Colorful)iGame1060烈焰战神U-3GD5 GTX1060 1556-1771/8008MHz3G/192bit吃鸡显卡	1700（直购）
	 * 风扇	美商海盗船（USCORSAIR） H55 H100i V2 一体化水冷 多平台静音风扇 H55	74.83（分6期） 待还款 375
	 * 机箱 爱国者（aigo）月光宝盒新月 黑色 钢化玻璃铝机箱（支持ATX主板/宽体大箱/铝制拉丝）	459（直购）
	 * 显示器 飞利浦（PHILIPS）31.5英寸 2K QHD高分辨率 低蓝不闪屏 FreeSync技术 电竞模式 电脑液晶显示器327E8FJSW	443（分三期） 待还款 886
	 * 键鼠
	 * 音箱
	 */
}
