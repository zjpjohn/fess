/*
 * Copyright 2009-2013 the Fess Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package jp.sf.fess.transformer;

import jp.sf.fess.FessSystemException;

import org.seasar.framework.container.SingletonS2Container;
import org.seasar.robot.entity.ResponseData;
import org.seasar.robot.extractor.Extractor;
import org.seasar.robot.extractor.ExtractorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FessFileTransformer extends AbstractFessFileTransformer {
    private static final Logger logger = LoggerFactory
            .getLogger(FessFileTransformer.class);

    @Override
    protected Extractor getExtractor(final ResponseData responseData) {
        final ExtractorFactory extractorFactory = SingletonS2Container
                .getComponent("extractorFactory");
        if (extractorFactory == null) {
            throw new FessSystemException("Could not find extractorFactory.");
        }
        final Extractor extractor = extractorFactory.getExtractor(responseData
                .getMimeType());
        if (logger.isDebugEnabled()) {
            logger.debug("url=" + responseData.getUrl() + ", extractor="
                    + extractor);
        }
        return extractor;
    }
}
