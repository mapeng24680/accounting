package com.student.logistics.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *类转换工具
 * @param <P> PO
 * @param <D> DTO
 */
public class DTOConverterUtils<P,D> {
	private Class<P> pClazz;
	private Class<D> dClazz;
	
	/**
	 * 
	 * @param pClazz PO对象类型
	 * @param dClazz DTO对象类型
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DTOConverterUtils(Class pClazz, Class dClazz) {
		this.pClazz = pClazz;
		this.dClazz = dClazz;
	}
	
	/**
	 * PO对象 --> DTO对象
	 * @return vo
	 */
	public D toDTO(P p) {
		try {
			D d = dClazz.newInstance();
			BeanUtils.copyProperties(p,d);
			return d;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * PO对象集合 --> DTO对象集合
	 * @param pList
	 * @return dList
	 */
	public List<D> toDTOList(List<P> pList){
		List<D> dList = new ArrayList<>();
		try {
			for(P p : pList){
				D d = dClazz.newInstance();
				BeanUtils.copyProperties(p, d);
				dList.add(d);
			}
			return dList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
	
	/**
	 * DTO对象 --> PO对象
	 * @return po
	 */
	public P toPO(D d) {
		try {
			P p = this.pClazz.newInstance();
			BeanUtils.copyProperties(d, p);
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * DTO对象集合 --> PO对象集合
	 * @param dList
	 * @return pList
	 */
	public List<P> toPOList(List<D> dList) {
		List<P> pList = new ArrayList<>();
		try {
			for(D d : dList){
				P p = this.pClazz.newInstance();
				BeanUtils.copyProperties(d, p);
				pList.add(p);
			}
			return pList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
