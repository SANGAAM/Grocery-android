package com.example.groceryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent


class GroceryRVAdapter
    (var list: List<GroceryItems>,
     val groceryItemCliclInterface: GroceryItemCliclInterface
) : RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>(){



    inner class GroceryViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val nameTV=itemView.findViewById<TextView>(R.id.idTVItemName)
        val quantityTV=itemView.findViewById<TextView>(R.id.idTVItemQuantity)
        val rateTV=itemView.findViewById<TextView>(R.id.idTVItemRate)
        val amountTV=itemView.findViewById<TextView>(R.id.idTVTotalAmt)
        val deleteTV=itemView.findViewById<TextView>(R.id.idTVDelete)



    }





    interface GroceryItemCliclInterface{
        fun onItemClick(groceryItems: GroceryItems)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item,parent,false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        holder.nameTV.text=list.get(position).itemName
        holder.quantityTV.text=list.get(position).itemQuantity.toString()
        holder.rateTV.text="Rs."+list.get(position).itemPrice.toString()
        val itemTotal : Int = list.get(position).itemPrice * list.get(position).itemQuantity
        holder.amountTV.text="Rs. +itemTotal.toString()"
        holder.deleteTV.setOnClickListener {
            groceryItemCliclInterface.onItemClick(list.get(position))
        }
    }

        override fun getItemCount(): Int {
            return list.size
        }

}


