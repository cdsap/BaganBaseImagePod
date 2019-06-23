import java.io.File
import java.util.*
import java.io.*

fun main() {
    val a = FileReader("gradle.properties");
    val p = Properties()
    p.load(a)
    println(p)
    gradleFileExists("build.gradle.kts")
    appendTalaiot("build.gradle.kts")
    createFileTalaiot()
}

fun gradleFileExists(path: String) = File(path).exists()

fun appendTalaiot(path: String) {
    File(path).appendText("\napply(from = \"talaiot.gradle.kts\")")

}

fun createFileTalaiot() {
    val file = File("talaiot.gradle.kts")
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
                "        classpath(\"com.cdsap:talaiot:0.3.2-SNAPSHOT\")\n" +
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
                "            url = \"http://localhost:8081\"\n" +
                "            urlMetric = \"tracking\"\n" +
                "        }\n" +
                "    }\n" +
                "}"
    )
}
