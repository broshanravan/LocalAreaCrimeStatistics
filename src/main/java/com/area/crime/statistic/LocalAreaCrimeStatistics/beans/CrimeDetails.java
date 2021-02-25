package com.area.crime.statistic.LocalAreaCrimeStatistics.beans;


import com.area.crime.statistic.LocalAreaCrimeStatistics.Enums.CategoryEnum;

import java.io.Serializable;
import java.util.Date;
public class CrimeDetails implements Serializable{
    private Date date;
    private CategoryEnum category;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
