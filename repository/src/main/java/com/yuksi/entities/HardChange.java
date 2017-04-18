package com.yuksi.entities;

import java.time.LocalDateTime;

/**
 * Created by Yuksi on 18.04.2017.
 */
public class HardChange extends AbstractEntity {
    long toChangeId;
    long whoChangesId;
    LocalDateTime change_date = LocalDateTime.now();

    public long getToChangeId() {
        return toChangeId;
    }

    public void setToChangeId(long toChangeId) {
        this.toChangeId = toChangeId;
    }

    public long getWhoChangesId() {
        return whoChangesId;
    }

    public void setWhoChangesId(long whoChangesId) {
        this.whoChangesId = whoChangesId;
    }

    public LocalDateTime getChange_date() {
        return change_date;
    }

    public void setChange_date(LocalDateTime change_date) {
        this.change_date = change_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HardChange that = (HardChange) o;

        if (id != that.id) return false;
        if (toChangeId != that.toChangeId) return false;
        if (whoChangesId != that.whoChangesId) return false;
        return change_date != null ? change_date.equals(that.change_date) : that.change_date == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (toChangeId ^ (toChangeId >>> 32));
        result = 31 * result + (int) (whoChangesId ^ (whoChangesId >>> 32));
        result = 31 * result + (change_date != null ? change_date.hashCode() : 0);
        return result;
    }
}
