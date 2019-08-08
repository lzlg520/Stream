package com.lzlg.domain.design;

import java.util.Collection;
import java.util.Iterator;

public class PrototypePacker implements WarehousePacker {

    @Override
    public void pack(Collection<Container> containers, Collection<Drum> drums) throws NoAnswerFoundException {
        Iterator<Drum> it = drums.iterator();
        while (it.hasNext()) {
            Drum drum = it.next();
            Container container = findContainer(containers, drum);
            container.add(drum);
        }
    }

    public Container findContainer(Collection<Container> containers, Drum drum) throws NoAnswerFoundException {
        Iterator<Container> it = containers.iterator();
        while (it.hasNext()) {
            Container container = it.next();
            if (container.canAccommodate(drum)) {
                return container;
            }
        }
        throw new NoAnswerFoundException();
    }
}
