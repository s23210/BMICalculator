package kotlin_exercises

/**
 * You have a set of protocols supported by your server. A user requests to use a particular protocol. Complete the program to check whether the requested protocol
 * is supported or not (isSupported must be a Boolean value).
 * fun main() {
 * val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
 * val requested = "smtp"
 * val isSupported = // Write your code here
 * println("Support for $requested: $isSupported")
 * }
 * Hint
 * Make sure that you check the requested protocol in upper case. You can use the .uppercase() function to help you with this.
 *
 */

fun main() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested.uppercase() in SUPPORTED
    println("Support for $requested: $isSupported")
}
