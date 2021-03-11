package hr.angryram.kontranto.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
@PropertySource("classpath:application.properties")
class DbConfig {

    @Autowired
    var iEnv: Environment? = null

    fun getProperty(pKey: String?): String? {
        return iEnv!!.getProperty(pKey!!)
    }

    @Primary
    @Bean(name = ["dbKontranto"])
    @Autowired
    fun dataSource(): DataSource? {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver")
        dataSource.url = iEnv!!.getProperty("cms.datasource.url")
        dataSource.username = iEnv!!.getProperty("cms.datasource.username")
        dataSource.password = iEnv!!.getProperty("cms.datasource.password")
        return dataSource
    }

    @Primary
    @Bean(name = ["jdbcKontranto"])
    @Autowired
    fun jdbcTemplate(@Qualifier("dbKontranto") pDataSource: DataSource?): JdbcTemplate? {
        return pDataSource?.let { JdbcTemplate(it) }
    }
}