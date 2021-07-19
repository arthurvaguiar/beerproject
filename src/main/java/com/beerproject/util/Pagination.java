package com.beerproject.util;

import java.util.Collection;
import java.util.Map;

public class Pagination<T> {


	    private Long total;
	    private Collection<T> rows;
	    private Map<String, Object> extra;

	    public Pagination() {
	    }

	    public Pagination(Long total, Collection<T> rows) {
	        this.total = total;
	        this.rows = rows;
	    }

	    public Pagination(Long total, Collection<T> rows, Map<String, Object> extra) {
	        this.total = total;
	        this.rows = rows;
	        this.extra = extra;
	    }

	    public Long getTotal() {
	        return total;
	    }

	    public void setTotal(Long total) {
	        this.total = total;
	    }

	    public Collection<T> getRows() {
	        return rows;
	    }

	    public void setRows(Collection<T> rows) {
	        this.rows = rows;
	    }

	    public Map<String, Object> getExtra() {
	        return extra;
	    }

	    public void setExtra(Map<String, Object> extra) {
	        this.extra = extra;
	    }

}
