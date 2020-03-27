package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry update(long timeEntryId, TimeEntry expected) ;

    public TimeEntry find(long timeEntryId) ;

    public TimeEntry create(TimeEntry timeEntryToCreate) ;

    public void delete(long timeEntryId) ;

    public List<TimeEntry> list() ;
}
