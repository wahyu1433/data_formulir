package com.example.formulirwithfirebase

class data_pasien {
    var nama: String? = null
    var ttl: String? = null
    var nomorhp: String? = null
    var alamat: String? = null
    var email: String? = null
    var jkel: String? = null
    var demam: String? = null
    var batuk: String? = null
    var pilek: String? = null
    var nyeri_tenggorokan: String? = null
    var sesak_nafas: String? = null
    var perjalanan_luar_negeri: String? = null
    var perjalanan_dalam_negeri: String? = null
    var jadwal: String? = null
//    var RadioGroup1: String? = null
//    var RadioGroup2: String? = null
//    var RadioGroup3: String? = null
//    var RadioGroup4: String? = null
//    var RadioGroup5: String? = null
//    var RadioGroup6: String? = null
//    var RadioGroup7: String? = null

    var key: String? = null

    constructor() {}
//    RadioGroup1: String?, RadioGroup2: String?,
//    RadioGroup3: String?, RadioGroup4: String?, RadioGroup5: String?, RadioGroup6: String?, RadioGroup7: String?,
    constructor(nama: String?,jkel: String?, ttl: String?, nomorhp: String?, alamat: String?, email: String?, demam: String?, batuk: String?,
                pilek: String?, nyeri_tenggorokan: String?, sesak_nafas: String?, perjalanan_luar_negeri: String?, perjalanan_dalam_negeri: String?, jadwal: String?) {
        this.nama = nama
        this.jkel = jkel
        this.ttl = ttl
        this.nomorhp = nomorhp
        this.alamat = alamat
        this.email = email
        this.demam = demam
        this.batuk = batuk
        this.pilek = pilek
        this.nyeri_tenggorokan = nyeri_tenggorokan
        this.sesak_nafas = sesak_nafas
        this.perjalanan_luar_negeri = perjalanan_luar_negeri
        this.perjalanan_dalam_negeri = perjalanan_dalam_negeri
        this.jadwal = jadwal

//        this.RadioGroup1 = RadioGroup1
//        this.RadioGroup2 = RadioGroup2
//        this.RadioGroup3 = RadioGroup3
//        this.RadioGroup4 = RadioGroup4
//        this.RadioGroup5 = RadioGroup5
//        this.RadioGroup6 = RadioGroup6
//        this.RadioGroup7 = RadioGroup7

    }

}