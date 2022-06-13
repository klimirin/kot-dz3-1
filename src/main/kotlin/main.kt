fun main() {
    var s = 780;
    println(agoToText(s));
}

fun agoToText(secondsCount: Int): String = when {
    secondsCount <= 60 -> "был(а) только что"
    secondsCount >= 61 && secondsCount <= 60 * 60 -> "был(а) в сети ${minutesText(secondsCount)}"
    secondsCount >= 60 * 60 + 1 && secondsCount <= 24 * 60 * 60 -> "был(а) в сети ${hoursText(secondsCount)}"
    secondsCount >= 24 * 60 * 60 + 1 && secondsCount <= 24 * 2 * 60 * 60 -> "был(а) в сети сегодня"
    secondsCount >= 24 * 2 * 60 * 60 + 1 && secondsCount <= 24 * 3 * 60 * 60 -> "был(а) в сети вчера"
    else -> "был(а) давно"
}

fun minutesText(secondsCount: Int): String {
    val minCount = secondsCount / 60;
    val minText = if (minCount / 10 == 1) "минут" else {
        when (minCount % 10) {
            1 -> "минуту"
            2, 3, 4 -> "минуты"
            else -> "минут"
        }
    }
    return "$minCount $minText назад"
}

fun hoursText(secondsCount: Int): String {
    val hourCount = secondsCount / 60 / 60;
    val hourText = if (hourCount / 10 == 1) "часов" else {
        when (hourCount % 10) {
            1 -> "час"
            2, 3, 4 -> "часа"
            else -> "часов"
        }
    }
    return "$hourCount $hourText назад"
}
