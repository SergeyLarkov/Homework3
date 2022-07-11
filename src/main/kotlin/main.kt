
fun min2text(m : Int) : String {
    return if (m % 10 == 1) "минуту"
           else if ((m % 10 < 5) && (m > 20))  m.toString() + " минуты"
           else m.toString() + " минут"
}

fun hour2text(h : Int) : String {
    return if (h % 10 == 1) "час"
           else if ((h % 10 < 5) && (h > 20)) h.toString() + " часа"
           else h.toString() + " часов"
}

fun time2text(seconds : Int) : Any {
    val minute = 60
    val hour =  minute * 60
    val day = hour * 24

    /*
    return if (seconds < minute) "только что"
           else if (seconds < hour) min2text(seconds / minute)
           else if (seconds < day) hour2text ( seconds / hour)
           else if (seconds < 2*day) "сегодня"
           else if (seconds < 3*day) "вчера"
           else "давно"
     */

    return when (seconds) {
        in 0..minute-1 -> "только что"
        in minute..hour-1 -> min2text(seconds / minute) + " назад"
        in hour..day-1 -> hour2text ( seconds / hour) + " назад"
        in day..2*day-1 -> "сегодня"
        in 2*day..3*day-1 -> "вчера"
        else -> "давно"
    }
}

fun main() {

    val timeAfterExit: Int = 19167
    val userName = "Вася"

    println("Пользователь " + userName + " был(a) в сети " + time2text(timeAfterExit))
}