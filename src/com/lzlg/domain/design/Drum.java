package com.lzlg.domain.design;

public class Drum {
    private double size;

    private ContainerSpecification specification;

    public Drum(int size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public ContainerSpecification getSpecification() {
        return specification;
    }

    public void setSpecification(ContainerSpecification specification) {
        this.specification = specification;
    }
}
