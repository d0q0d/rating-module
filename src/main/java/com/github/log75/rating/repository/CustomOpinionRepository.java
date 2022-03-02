package com.github.log75.rating.repository;

import com.github.log75.rating.model.KeyQueryParam;

/**
 * The custom opinion repository interface.
 *
 */
public interface CustomOpinionRepository {
    /**
     * Add key.
     *
     * @param queryParam the query param
     */
    void addKey(KeyQueryParam queryParam);

    /**
     * Remove key.
     *
     * @param queryParam the query param
     */
    void removeKey(KeyQueryParam queryParam);
}
