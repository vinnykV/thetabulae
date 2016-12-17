package com.tabula.drugs.model.functions;

/**
 * @author Vladyslav_Vinnyk on 12/16/2016.
 */
public interface Function<T extends String, P extends Integer, R extends Object> {
    R aply(T input, P index);
}
