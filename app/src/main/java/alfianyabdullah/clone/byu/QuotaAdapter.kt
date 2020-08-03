package alfianyabdullah.clone.byu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_quota.view.*

class QuotaAdapter : RecyclerView.Adapter<QuotaAdapter.QuotaHolder>() {

    class QuotaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindContent(quota: Quota) {
            itemView.rowQuotaName.text = quota.name
            itemView.rowQuota.text = quota.quota
            itemView.rowQuotaTime.text = quota.time
            itemView.rowQuotaPrice.text = quota.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_quota, parent, false)
        return QuotaHolder(view)
    }

    override fun getItemCount() = DataManager.quotas.size

    override fun onBindViewHolder(holder: QuotaHolder, position: Int) {
        val quota = DataManager.quotas[position]
        holder.bindContent(quota)
    }
}