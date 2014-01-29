/*
 * Copyright 2014 jts
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.jts.authserver.info;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

/**
 * @author Grizly(Skype: r-grizly)
 * @since 29.01.2014
 */
public class MemoryInfo {
    public static double getMemoryUsagePercent() {
        MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        return 100.0F * (float) heapMemoryUsage.getUsed() / (float) heapMemoryUsage.getMax();
    }

    public static double getMemoryFreePercent() {
        return 100.0D - getMemoryUsagePercent();
    }

    public static String getMemoryMaxMb() {
        return getMemoryMax() / 1048576L + " mb";
    }

    public static String getMemoryUsedMb() {
        return getMemoryUsed() / 1048576L + " mb";
    }

    public static long getMemoryMax() {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax();
    }

    public static long getMemoryUsed() {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
    }
}
