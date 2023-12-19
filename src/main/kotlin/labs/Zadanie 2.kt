
fun main(args: Array<String>) {
    fun calculateCommission(
        cardType: String = "VK Pay",
        previousTransfers: Int = 0,
        transferAmount: Int
    ): Int {
        val masterCardMaestroLimit = 60000
        val visaMirLimit = 150000
        val commissionRate = 0.75
        var commission = 0
        if (cardType == "MasterCard" || cardType == "Maestro") {
            if (previousTransfers + transferAmount > masterCardMaestroLimit) {
                commission = ((previousTransfers + transferAmount - masterCardMaestroLimit) * commissionRate).toInt()
            }
        } else if (cardType == "Visa" || cardType == "Mir") {
            commission = (transferAmount * commissionRate).toInt()
            if (commission > visaMirLimit) {
                commission = visaMirLimit
            }
        }
        return commission
    }
}