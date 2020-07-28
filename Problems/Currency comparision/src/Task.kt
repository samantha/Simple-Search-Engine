import java.util.Scanner

enum class Currency(val country: String, val currency: String) {
    GERMANY("Germany", "Euro"), 
    MALI("Mali", "CFA franc"),
    DOMINICA("Dominica", "Eastern Caribbean dollar"),
    CANADA("Canada", "Canadian dollar"),
    SPAIN("Spain", "Euro"),
    AUSTRALIA("Australia", "Australian dollar"),
    BRAZIL("Brazil", "Brazilian real"),
    SENEGAL("Senegal", "CFA franc"),
    FRANCE("France", "Euro"),
    GRENADA("Grenada", "Eastern Caribbean dollar"),
    KIRIBATA("Kiribati", "Australian dollar"),
    NULL("", "");
    
    companion object {
        fun findCurrencyByCountry(country: String): String{
            for (enum in Currency.values()) {
                if (country == enum.country) {
                    return (enum.currency)
                }
            }
            return NULL.currency
        }
    }
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // put your code here
    while(input.hasNext()) {
        val country1 = input.next()
        val currency1 = Currency.findCurrencyByCountry(country1)
        val country2 = input.next()
        val currency2 = Currency.findCurrencyByCountry(country2)
        if (currency1 == currency2) {
            println("true")
        }
        else {
            println("false")
        }
    }
}
