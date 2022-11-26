package br.com.reccos.admin.config;

import org.springframework.beans.factory.annotation.Value;

public class DevConfig {
//	@Autowired
//	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
//	@Bean
//	public boolean instanciaDB() {
//		if(value.equals("create")) {
//			this.dbService.InstanciaDB();
//		}
//		return false;
//	}
}
