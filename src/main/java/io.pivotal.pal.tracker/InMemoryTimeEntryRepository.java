package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

   private Map<Long, TimeEntry> timeEntryMap = new HashMap<>();


   @Override
   public TimeEntry create(TimeEntry timeEntry) {

        timeEntryMap.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(long id) {
        timeEntryMap.remove(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntryMap.values());
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return timeEntryMap.get(timeEntryId);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

       if(timeEntryMap.get(id) != null) {
           timeEntryMap.replace(id, timeEntry);
           //timeEntry.setId(id);
           return timeEntry;
       }

        return null;
    }
}
