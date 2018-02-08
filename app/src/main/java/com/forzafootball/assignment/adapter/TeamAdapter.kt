package com.forzafootball.assignment.adapter

import android.content.Context
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.forzafootball.assignment.R
import com.forzafootball.assignment.dbdata.db.TeamDB
import android.support.v4.content.ContextCompat

/**
 * Created by pavel on 6/2/18.
 */

class TeamAdapter(private val teamList: List<TeamDB>, private val context: Context): RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.txtName?.text = teamList[position].name
        holder?.txtCountry?.text = teamList[position].country_name

        if(teamList[position].national != null) {
            if (teamList[position].national) {
                holder?.txtNational?.text = context.resources.getString(R.string.national)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder?.txtNational?.setTextColor(context.getColor(R.color.green_font))
                } else {
                    val green = ContextCompat.getColor(context, R.color.green_font)
                    holder?.txtNational?.setTextColor(green)
                }

            } else {
                holder?.txtNational?.text = context.resources.getString(R.string.international)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    holder?.txtNational?.setTextColor(context.getColor(R.color.blue_font))
                } else {
                    val blue = ContextCompat.getColor(context, R.color.blue_font)
                    holder?.txtNational?.setTextColor(blue)
                }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.team_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtName = itemView.findViewById<TextView>(R.id.name)!!
        val txtCountry = itemView.findViewById<TextView>(R.id.country_name)!!
        val txtNational = itemView.findViewById<TextView>(R.id.national)!!

    }

}