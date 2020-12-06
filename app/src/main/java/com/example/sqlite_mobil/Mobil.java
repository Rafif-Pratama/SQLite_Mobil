package com.example.sqlite_mobil;

public class Mobil {
    private String _id, _merk, _jenis, _tahun;
    public Mobil (String id, String merk, String jenis, String tahun) {
        this._id = id;
        this._merk = merk;
        this._jenis = jenis;
        this._tahun = tahun;
    }
    public Mobil() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_merk() {
        return _merk;
    }
    public void set_merk(String _merk) {
        this._merk = _merk;
    }
    public String get_jenis() {
        return _jenis;
    }
    public void set_jenis(String _jenis) {
        this._jenis = _jenis;
    }
    public String get_tahun() {
        return _tahun;
    }
    public void set_tahun(String _tahun) {
        this._tahun = _tahun;
    }


}
