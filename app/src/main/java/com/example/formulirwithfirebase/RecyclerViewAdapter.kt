package com.example.formulirwithfirebase

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private var listPasien: ArrayList<data_pasien>, context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    private var context: Context
    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Nama: TextView
        val Jeniskelamin: TextView
        val TglLahir: TextView
        val NomorHp: TextView
        val Alamat: TextView
        val Email: TextView
        val Demam: TextView
        val Batuk: TextView
        val Pilek: TextView
        val Nyeri: TextView
        val Sesak: TextView
        val Luar: TextView
        val Dalam: TextView
        val Jadwal: TextView
        val ListItem: LinearLayout
        init {//Menginisialisasi View yang terpasang pada layout RecyclerView kita
            Nama = itemView.findViewById(R.id.namax)
            Jeniskelamin = itemView.findViewById(R.id.jenis_kelaminx)
            TglLahir = itemView.findViewById(R.id.tgllahirx)
            NomorHp = itemView.findViewById(R.id.nomorhpx)
            Alamat = itemView.findViewById(R.id.alamatx)
            Email = itemView.findViewById(R.id.emailx)
            Demam = itemView.findViewById(R.id.demamx)
            Batuk = itemView.findViewById(R.id.batukx)
            Pilek = itemView.findViewById(R.id.pilekx)
            Nyeri = itemView.findViewById(R.id.nyeritenggorokanx)
            Sesak= itemView.findViewById(R.id.sesakx)
            Luar = itemView.findViewById(R.id.luarnegerix)
            Dalam = itemView.findViewById(R.id.dalamnegerix)
            Jadwal = itemView.findViewById(R.id.jadwalx)


            ListItem = itemView.findViewById(R.id.list_item)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
//Membuat View untuk Menyiapkan & Memasang Layout yang digunakan pada RecyclerView
        val V: View = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.view_design, parent, false)
        return ViewHolder(V)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//Mengambil Nilai/Value pada RecyclerView berdasarkan Posisi Tertentu
        val Nama: String? = listPasien.get(position).nama
        val Jeniskelamin: String? = listPasien.get(position).jkel
        val TglLahir: String? = listPasien.get(position).ttl
        val NomorHp: String? = listPasien.get(position).nomorhp
        val Alamat: String? = listPasien.get(position).alamat
        val Email: String? = listPasien.get(position).email
        val Demam: String? = listPasien.get(position).demam
        val Batuk: String? = listPasien.get(position).batuk
        val Pilek: String? = listPasien.get(position).pilek
        val Nyeri: String? = listPasien.get(position).nyeri_tenggorokan
        val Sesak: String? = listPasien.get(position).sesak_nafas
        val Luar: String? = listPasien.get(position).perjalanan_luar_negeri
        val Dalam: String? = listPasien.get(position).perjalanan_dalam_negeri
        val Jadwal: String? = listPasien.get(position).jadwal
//Memasukan Nilai/Value kedalam View (TextView: NIM, Nama, Jurusan)
        holder.Nama.text = "Nama: $Nama"
        holder.Jeniskelamin.text = "Jenis Kelamin: $Jeniskelamin"
        holder.TglLahir.text = "Tanggal Lahir: $TglLahir"
        holder.NomorHp.text = "Nomor Hp: $NomorHp"
        holder.Alamat.text = "Alamat: $Alamat"
        holder.Email.text = "Email: $Email"
        holder.Demam.text = "Demam: $Demam"
        holder.Batuk.text = "Batuk: $Batuk"
        holder.Pilek.text = "Pilek: $Pilek"
        holder.Nyeri.text = "Nyeri: $Nyeri"
        holder.Sesak.text = "Sesak: $Sesak"
        holder.Luar.text = "Perjalanan Luar Negeri: $Luar"
        holder.Dalam.text = "Perjlanan Dalam Negeri: $Dalam"
        holder.Jadwal.text = "Jadwal: $Jadwal"
        holder.ListItem.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
//Kodingan untuk fungsi Edit dan Delete, yang dibahas pada Tutorial Berikutnya.
                holder.ListItem.setOnLongClickListener { view ->
                    val action = arrayOf("Update", "Delete")
                    val alert: AlertDialog.Builder = AlertDialog.Builder(view.context)
                    alert.setItems(action, DialogInterface.OnClickListener { dialog, i ->
                        when (i) {
                            0 -> {
/* Berpindah Activity pada halaman layout updateData dan mengambil data pada
listMahasiswa, berdasarkan posisinya untuk dikirim pada activity selanjutnya */
                                val bundle = Bundle()
                                bundle.putString("dataNama", listPasien[position].nama)
                                bundle.putString("dataJeniskelamin", listPasien[position].jkel)
                                bundle.putString("dataTglLahir", listPasien[position].ttl)
                                bundle.putString("dataNomorHp", listPasien[position].nomorhp)
                                bundle.putString("dataAlamat", listPasien[position].alamat)
                                bundle.putString("dataEmail", listPasien[position].email)
                                bundle.putString("dataDemam", listPasien[position].demam)
                                bundle.putString("dataBatuk", listPasien[position].batuk)
                                bundle.putString("dataPilek", listPasien[position].pilek)
                                bundle.putString("dataNyeri", listPasien[position].nyeri_tenggorokan)
                                bundle.putString("dataSesak", listPasien[position].sesak_nafas)
                                bundle.putString("dataLuar", listPasien[position].perjalanan_luar_negeri)
                                bundle.putString("dataDalam", listPasien[position].perjalanan_dalam_negeri)
                                bundle.putString("dataJadwal", listPasien[position].jadwal)
                                bundle.putString("getPrimaryKey", listPasien[position].key)
                                val intent = Intent(view.context, UpdateData::class.java)
                                intent.putExtras(bundle)
                                context.startActivity(intent)
                            }
                            1 -> {
                                //Menggunakan interface untuk mengirim data mahasiswa, yang akan dihapus
                                listener?.onDeleteData(listPasien.get(position), position)
                            }
                        }
                    })
                    alert.create()
                    alert.show()
                    true
                }
                return true
            }
        })
    }
    override fun getItemCount(): Int {
//Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return listPasien.size
    }

    var listener: dataListener? = null
    //Membuat Konstruktor, untuk menerima input dari Database
    init {
        this.context = context
        this.listener =  context as MyListData
    }

    //Membuat Interfece
    interface dataListener {
        fun onDeleteData(data: data_pasien?, position: Int)
    }


    fun RecyclerViewAdapter(listPasien: ArrayList<data_pasien>?, context: Context?){
        this.listPasien = listPasien!!
        this.context = context!!
        listener = context as MyListData?
    }
}