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
package com.tom_roush.pdfbox.util;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Uwe Pachler
 */
public class TestQuickSort extends TestCase
{
    <T extends Comparable<T>> void doTest(T[] input, T[] expected)
    {
        List<T> list = Arrays.asList(input);
        QuickSort.sort(list);

        boolean equal = Arrays.equals(list.toArray(new Object[input.length]), input);

        assertTrue(equal);
    }

    /**
     * Test for different cases.
     */
    public void testSort()
    {
        {
            Integer[] input = new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
            Integer[] expected = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            doTest(input, expected);
        }

        {
            Integer[] input = new Integer[] { 4, 3, 2, 1, 9, 8, 7, 6, 5 };
            Integer[] expected = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            doTest(input, expected);
        }

        {
            Integer[] input = new Integer[] {};
            Integer[] expected = new Integer[] {};
            doTest(input, expected);
        }

        {
            Integer[] input = new Integer[] { 5 };
            Integer[] expected = new Integer[] { 5 };
            doTest(input, expected);
        }

        {
            Integer[] input = new Integer[] { 5, 6 };
            Integer[] expected = new Integer[] { 5, 6 };
            doTest(input, expected);
        }

        {
            Integer[] input = new Integer[] { 6, 5 };
            Integer[] expected = new Integer[] { 5, 6 };
            doTest(input, expected);
        }
    }
}
