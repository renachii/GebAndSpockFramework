package spocktest

import org.apache.log4j.*

String projDir = new File(System.getProperty("user.dir")).toPath()
ConfigObject config = new ConfigSlurper().parse(new File("${projDir}/src/main/resources/log4jconfig.groovy").toURL())
PropertyConfigurator.configure config.toProperties()
Logger log = Logger.getInstance(getClass()) as Logger

log.level = Level.INFO