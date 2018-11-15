/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tom_roush.pdfbox.pdmodel;

import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.pdmodel.common.PDNameTreeNode;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement;

import java.io.IOException;

/**
 * todo: JavaDoc
 *
 * @author John Hewson
 */
public class PDStructureElementNameTreeNode extends PDNameTreeNode<PDStructureElement>
{
    /**
     * Constructor.
     */
    public PDStructureElementNameTreeNode()
    {
        super();
    }

    /**
     * Constructor.
     *
     * @param dic The COS dictionary.
     */
    public PDStructureElementNameTreeNode(COSDictionary dic)
    {
        super(dic);
    }

    @Override
    protected PDStructureElement convertCOSToPD(COSBase base) throws IOException
    {
        return new PDStructureElement((COSDictionary) base);
    }

    @Override
    protected PDNameTreeNode createChildNode(COSDictionary dic)
    {
        return new PDStructureElementNameTreeNode(dic);
    }
}
