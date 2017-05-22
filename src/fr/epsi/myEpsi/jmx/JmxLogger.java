package fr.epsi.myEpsi.jmx;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
public class JmxLogger implements JmxLoggerMBean{


	String currentLevel;
	LoggerConfig loggerConfig;
	Configuration config;
	LoggerContext ctx;
	
	public JmxLogger() {
		
		ctx = (LoggerContext) LogManager.getContext(false);
		config = ctx.getConfiguration();
		loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME); 
		currentLevel = loggerConfig.getLevel().toString();
	}
	
	@Override
	public String getLogLevel() {
		currentLevel = loggerConfig.getLevel().toString();
		return currentLevel;
	}

	@Override
	public void setLogLevel(String level) {
		Level l = Level.getLevel(level);
		loggerConfig.setLevel(l);
		ctx.updateLoggers(); 
	}
}
