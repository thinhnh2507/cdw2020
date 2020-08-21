package com.example.CDWSecurity.repository;

import com.example.CDWSecurity.model.DanhMuc;
import com.example.CDWSecurity.model.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu,Long> {
    @Query(value = "select th from ThuongHieu th where th.danhMuc.id_danhmuc = :id")
    List<ThuongHieu> getthbydanhmuc(Long id);

}
