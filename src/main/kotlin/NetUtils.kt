import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.net.InetAddress
import java.nio.ByteBuffer

object NetUtils {
    val dataScope = CoroutineScope(Dispatchers.IO)
    fun intToIp(paramInt: Int): String {
        return ((paramInt.and(255)).toString() + "." + (paramInt.shr(8).and(255)) + "." + (paramInt.shr(16).and(255)) + "."
                + (paramInt.shr(24).and(255)))
    }
    fun intToIp2(paramInt: Int): String {
        return ((paramInt.and(255)).toString() + "." + (paramInt.shr(8).and(255)) + "." + (paramInt.shr(16).and(255)) + ".")
    }
    fun intToIp3(paramInt: Int): Int {
        return (paramInt.shr(24).and(255))
    }

    fun bytebuffer2ByteArray(buffer: ByteBuffer): ByteArray {
        buffer.flip()
        val len = buffer.limit() - buffer.position()
        val bytes = ByteArray(len)
        for (i in bytes.indices) {
            bytes[i] = buffer.get()
        }
        return bytes
    }

    fun ip2String(s: InetAddress):String{
        var ip=s.toString()
        ip=ip.substring(ip.lastIndexOf("/")+1)
        return ip
    }

    /**
     * description: 使用 String.format 格式化数字，实现左侧补 0
     * @param num  需要格式化的数字
     * @param digit 生成字符串长度（保留数字位数）
     * @return String
     * @version v1.0
     * @author w
     * @date 2019年7月19日 下午2:14:31
     */
    fun fillString(num: Int, digit: Int): String? {
        /**
         * 0：表示前面补0
         * digit：表示保留数字位数
         * d：表示参数为正数类型
         */
        return String.format("%0" + digit + "d", num)
    }
}