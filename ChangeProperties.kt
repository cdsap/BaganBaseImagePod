import java.io.StringReader
import java.util.*
import java.io.FileInputStream
import java.io.FileOutputStream


fun main() {
    val b = StringReader(System.getenv("experiments"))
    val newProps = Properties()
    newProps.load(b)

    val inProperties = FileInputStream("gradle.properties")
    val props = Properties()

    props.load(inProperties)
    inProperties.close()

    val outProperties = FileOutputStream("gradle.properties")
    newProps.forEach {
        props.setProperty(it.key.toString(), it.value.toString())
    }
    props.store(outProperties, null)
    outProperties.close()
}