package hr.ferit.sandroblavicki.rma_lv3_zad2.listeners

interface PersonInteractionListener {
    fun onRemove(id: Long)
    fun onShowQuote(id: Long)
    fun onEditDetails(id: Int)
}