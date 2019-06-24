import java.io.File
import java.util.*
import java.io.*

fun main() {
    val a = FileReader("gradle.properties");
    val p = Properties()
    p.load(a)
    println(p)
    gradleFileExists("build.gradle.kts")
    println(1)
    appendTalaiot("build.gradle.kts")
    println(2)
    createFileTalaiot()
    println(3)

}

fun gradleFileExists(path: String) = File(path).exists()

fun appendTalaiot(path: String) {
    File(path).appendText("\napply(from = \"talaiot.gradle.kts\")")

}

fun createFileTalaiot() {
    val file = File("talaiot.gradle.kts")
    println(5)

    file.writeText(
        "" +
                "buildscript {\n" +
                "    repositories {\n" +
                "        mavenCentral()\n" +
                "        google()\n" +
                "        mavenLocal()\n" +
                "        jcenter()\n" +
                "\n" +
                "    }\n" +
                "    dependencies {\n" +
                "        classpath(\"com.cdsap:talaiot:0.4.0\")\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "apply<com.cdsap.talaiot.TalaiotPlugin>()\n" +
                "configure<com.cdsap.talaiot.TalaiotExtension>() {\n" +
                "    logger = com.cdsap.talaiot.logger.LogTracker.Mode.INFO\n" +
                "    publishers {\n" +
                "\n" +
                "        influxDbPublisher {\n" +
                "            dbName = \"tracking\"\n" +
                "            url = \"http://bagan-influxdb.default:8086\"\n" +
                "            urlMetric = \"tracking\"\n" +
                "        }\n" +
                "    }\n" +
                "}"
    )
    println(6)

}
