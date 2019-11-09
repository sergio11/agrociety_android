package sanchez.sanchez.sergio.agrociety.ui.features.main.components.bottomnav.listener


interface ISpaceOnClickListener {
    fun onCentreButtonClick()
    fun onItemClick(itemIndex: Int, itemName: String)
    fun onItemReselected(itemIndex: Int, itemName: String)
}