/*
 * Copyright (c) 1997, 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package java.lang;

/**
 * TBD
 *
 * @param <T> the type of objects that this object may be compared to
 *
 * @author  Dmytro Sheyko
 * @see java.lang.Comparable
 * @see java.lang.Object#equals(java.lang.Object)
 * @since 15
 */
public interface Equable<T> {
    /**
     * Compares this object with the specified object for equality.
     * TBD
     *
     * @param   o the object to be compared.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     *
     * @throws NullPointerException if the specified object is null
     */
    boolean equ(T o);
}
