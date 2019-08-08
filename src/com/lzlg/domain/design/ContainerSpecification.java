package com.lzlg.domain.design;

public class ContainerSpecification {
    private ContainerFeature requiredFeature;

    public ContainerSpecification(ContainerFeature required) {
        this.requiredFeature = required;
    }

    public boolean isSatisfiedBy(Container container) {
        return container.getFeatures().contains(requiredFeature);
    }
}
