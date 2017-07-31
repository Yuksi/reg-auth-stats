package com.yuksi.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Yuksi on 18.04.2017.
 */

@Entity
@Table(name="CHANGES_TOTAL")
public class HardChange {

    @Id
    @Column(name="id_changing")
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name="id_to_change")
    long toChangeId;

    @Column(name="id_who_changes")
    long whoChangesId;

    @Column(name="change_date")
    LocalDateTime changeDate = LocalDateTime.now();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HardChange that = (HardChange) o;

        if (id != that.id) return false;
        if (toChangeId != that.toChangeId) return false;
        if (whoChangesId != that.whoChangesId) return false;
        return changeDate != null ? changeDate.equals(that.changeDate) : that.changeDate == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (toChangeId ^ (toChangeId >>> 32));
        result = 31 * result + (int) (whoChangesId ^ (whoChangesId >>> 32));
        result = 31 * result + (changeDate != null ? changeDate.hashCode() : 0);
        return result;
    }
}
