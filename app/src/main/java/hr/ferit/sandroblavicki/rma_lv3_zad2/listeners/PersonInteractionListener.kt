package hr.ferit.sandroblavicki.rma_lv3_zad2.listeners

interface PersonInteractionListener {
    fun onRemove(id: Int)
    fun onShowQuote(id: Int)
    fun onEditDetails(id: Int)
}