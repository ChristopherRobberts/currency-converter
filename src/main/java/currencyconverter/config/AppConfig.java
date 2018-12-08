package currencyconverter.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.h2.server.web.WebServlet;


@EnableTransactionManagement
@EnableWebMvc
@Configuration
public class AppConfig implements ApplicationContextAware, WebMvcConfigurer {
    private ApplicationContext context;

    @Bean
    public ThymeleafViewResolver tlViewResolver() {
        ThymeleafViewResolver tlViewResolver = new ThymeleafViewResolver();
        tlViewResolver.setContentType("text/html; charset=UTF-8");
        tlViewResolver.setCharacterEncoding("UTF-8");
        tlViewResolver.setTemplateEngine(handleTemplateEngine());
        return tlViewResolver;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }

    @Bean(name = "currencyConverterTemplateEngine")
    public SpringTemplateEngine handleTemplateEngine() {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(getResolvedTemplate());
        springTemplateEngine.setEnableSpringELCompiler(true);
        springTemplateEngine.addDialect(new LayoutDialect());
        return springTemplateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver getResolvedTemplate() {
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setApplicationContext(this.context);
        springResourceTemplateResolver.setPrefix("classpath:/html-pages/");
        springResourceTemplateResolver.setSuffix(".html");
        springResourceTemplateResolver.setTemplateMode(TemplateMode.HTML);
        springResourceTemplateResolver.setCacheable(true);
        return springResourceTemplateResolver;
    }

    public void addResourceHandlers(ResourceHandlerRegistry reg) {
        String dirForCSS = "classpath:/html-pages/";

        reg.addResourceHandler("/**").addResourceLocations(dirForCSS).setCachePeriod(1)
                .resourceChain(true).addResolver(new PathResourceResolver());
    }

    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

}
