package com.lzlg.domain.design;

import java.util.Iterator;
import java.util.Set;

public class Container {
    private double capacity;

    private Set<ContainerFeature> features;

    private Set<Drum> contents;

    public Container(int capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public Set<ContainerFeature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<ContainerFeature> features) {
        this.features = features;
    }

    public boolean hasSpaceFor(Drum drum) {
        return remainingSpace() >= drum.getSize();
    }

    public double remainingSpace() {
        double totalContentSize = 0;
        Iterator<Drum> it = contents.iterator();
        while (it.hasNext()) {
            Drum drum = it.next();
            totalContentSize += drum.getSize();
        }
        return capacity - totalContentSize;
    }

    public boolean canAccommodate(Drum drum) {
        return hasSpaceFor(drum) && drum.getSpecification().isSatisfiedBy(this);
    }

    public void add(Drum drum) {
        contents.add(drum);
    }

    public boolean isSafelyPacked() {
        Iterator<Drum> it = contents.iterator();
        while (it.hasNext()) {
            Drum drum = it.next();
            if (!drum.getSpecification().isSatisfiedBy(this)) {
                return false;
            }
        }
        return true;
    }
}
