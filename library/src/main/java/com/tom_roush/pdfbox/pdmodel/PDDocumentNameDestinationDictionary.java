/*
 * Copyright 2015 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import com.tom_roush.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;

import java.io.IOException;

/**
 * This encapsulates the "dictionary of names and corresponding destinations" for the /Dest entry in
 * the document catalog.
 *
 * @author Tilman Hausherr
 */
public class PDDocumentNameDestinationDictionary implements COSObjectable
{
    private final COSDictionary nameDictionary;

    /**
     * Constructor.
     *
     * @param dict The dictionary of names and corresponding destinations.
     */
    public PDDocumentNameDestinationDictionary(COSDictionary dict)
    {
        this.nameDictionary = dict;
    }

    /**
     * Convert this standard java object to a COS object.
     *
     * @return The cos dictionary for this object.
     */
    @Override
    public COSDictionary getCOSObject()
    {
        return nameDictionary;
    }

    /**
     * Returns the destination corresponding to the parameter.
     *
     * @param name The destination name.
     * @return The destination for that name, or null if there isn't any.
     * @throws IOException if something goes wrong when creating the destination object.
     */
    public PDDestination getDestination(String name) throws IOException
    {
        COSBase item = nameDictionary.getDictionaryObject(name);
        return PDDestination.create(item);
    }
}