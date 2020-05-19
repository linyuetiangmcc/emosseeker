package com.gmcc.emosseeker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DataRaw {
    @JsonProperty("endRow")
    private int endrow;
    @JsonProperty("hasNextPage")
    private boolean hasnextpage;
    @JsonProperty("hasPreviousPage")
    private boolean haspreviouspage;
    @JsonProperty("isFirstPage")
    private boolean isfirstpage;
    @JsonProperty("isLastPage")
    private boolean islastpage;
    private List<ListRaw> list;
    @JsonProperty("navigateFirstPage")
    private int navigatefirstpage;
    @JsonProperty("navigateLastPage")
    private int navigatelastpage;
    @JsonProperty("navigatePages")
    private int navigatepages;
    @JsonProperty("navigatepageNums")
    private List<Integer> navigatepagenums;
    @JsonProperty("nextPage")
    private int nextpage;
    @JsonProperty("pageNum")
    private int pagenum;
    @JsonProperty("pageSize")
    private int pagesize;
    private int pages;
    @JsonProperty("prePage")
    private int prepage;
    private int size;
    @JsonProperty("startRow")
    private int startrow;
    private int total;
}
