import com.vaca.localudpscan.net.NetSetting
import kotlinx.coroutines.launch
import java.awt.Desktop
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Inet4Address


object UdpE {

    private const val DEFAULT_GATEWAY = "Default Gateway"
    @JvmStatic
    fun main(args: Array<String>) {
        println("fuck")
        NetSetting.myIp=Inet4Address.getLocalHost().hostAddress
        //val process = Runtime.getRuntime().exec("ipconfig")
       /* BufferedReader(
            InputStreamReader(process.inputStream)
        ).use { bufferedReader ->
            var line: String=""
            while (bufferedReader.readLine()?.also { line = it } != null) {
                if (line.trim { it <= ' ' }.startsWith(DEFAULT_GATEWAY)) {
                    val ipAddress = line.substring(line.indexOf(":") + 1).trim { it <= ' ' }
                    println(ipAddress)
                    NetSetting.gate=ipAddress
                }
            }
        }*/
        println(NetSetting.myIp)
        Thread.sleep(1000)
        NetUtils.dataScope.launch {
            UdpServer.udpServerStart()
        }
        while (true);
    }
}