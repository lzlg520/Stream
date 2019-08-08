package com.lzlg.domain.design;

import java.util.Collection;

public interface WarehousePacker {

    void pack(Collection<Container> containers, Collection<Drum> drums)
            throws NoAnswerFoundException;
}
