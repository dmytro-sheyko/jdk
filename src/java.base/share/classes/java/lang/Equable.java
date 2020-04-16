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
 * This interface imposes an equality relation on the objects that of each
 * class that implements it.<p>
 *
 * The purpose of the interface is to to reject attempts to compare values
 * of different incomparable types at compile time. It has a method
 * {@link Equable#equ(Object) Equable&lt;T&gt;.equ(T)}, which behaves exactly as
 * {@link Object#equals(Object) Object.equals(Object)} if the values are
 * non-null and the types of the values are comparable. However if the types
 * of the values are incomparable, the compiler reports an error.<p>
 *
 * The commonalities and differences between
 * {@link Object#equals(Object) Object.equals(Object)} and
 * {@link Equable#equ(Object) Equable&lt;T&gt;.equ(T)} are summarised in
 * following table:
 * <table class="plain">
 *  <thead style="text-align:center">
 *   <tr>
 *    <th style="width:25%"></th>
 *    <th style="width:25%">{@code a.equals(b)}</th>
 *    <th style="width:25%">{@code a.equ(b)}</th>
 *    <th style="width:25%">{@code a.compareTo(b) == 0}</th>
 *   </tr>
 *  </thead>
 *  <tbody style="text-align:left">
 *   <tr>
 *    <td>{@code a} and {@code b} have comparable types,<br>
 *     and {@code a} is equal to {@code b}</td>
 *    <td colspan="3" style="text-align:center">{@code true}</td>
 *   </tr>
 *   <tr>
 *    <td>{@code a} and {@code b} have comparable types,<br>
 *     but {@code a} isn't equal to {@code b}</td>
 *    <td colspan="3" style="text-align:center">{@code false}</td>
 *   </tr>
 *   <tr>
 *    <td>{@code a} and {@code b} have incomparable types</td>
 *    <td colspan="1" style="text-align:center">{@code false}</td>
 *    <td colspan="2">compilation error<br>(or {@link ClassCastException}
 *     if it is called through the bridge method)</td>
 *   </tr>
 *   <tr>
 *    <td>{@code b} is {@code null}</td>
 *    <td colspan="1" style="text-align:center">{@code false}</td>
 *    <td colspan="2">{@link NullPointerException}</td>
 *   </tr>
 *  </tbody>
 * </table>
 *
 * The equality relation is more general than total order relation,
 * therefore interface {@link Comparable Comparable&lt;T&gt;} extends
 * {@link Equable Equable&lt;T&gt;}. It's not however required that all
 * {@link Equable} classes be {@link Comparable}.<p>
 *
 * It is strongly recommended that
 * {@link Equable#equ(Object) Equable&lt;T&gt;.equ(T)} be consistent with
 * {@link Object#equals(Object) Object.equals(Object)} and
 * {@link Comparable#compareTo(Object) Comparable&lt;T&gt;.compareTo(T)}.
 * In case if
 * {@link Object#equals(Object) Object.equals(Object)} and
 * {@link Comparable#compareTo(Object) Comparable&lt;T&gt;.compareTo(T)}
 * are inconsistent, it's prefered that
 * {@link Equable#equ(Object) Equable&lt;T&gt;.equ(T)} be consistent with
 * {@link Comparable#compareTo(Object) Comparable&lt;T&gt;.compareTo(T)}
 * rather than with
 * {@link Object#equals(Object) Object.equals(Object)}.<p>
 *
 * One of the ways to ensure that
 * {@link Equable#equ(Object) Equable&lt;T&gt;.equ(T)} and
 * {@link Object#equals(Object) Object.equals(Object)} are consistent
 * is to implement {@link Object#equals(Object) Object.equals(Object)}
 * through {@link Equable#equ(Object) Equable&lt;T&gt;.equ(T)}.
 * <pre>
 *     class Example implements Equable&lt;Example&gt; {
 *         . . .
 *         &#64;Override
 *         public boolean equals(Object obj) {
 *             return obj instanceof Example that &amp;&amp; equ(that);
 *         }
 *         . . .
 *     }
 * </pre>
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
     *
     * @param   obj   the reference object with which to compare.
     * @return  {@code true} if this object is equal to the obj
     *          argument; {@code false} otherwise.
     *
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException if the specified object's type prevents it
     *         from being compared to this object.
     */
    boolean equ(T obj);
}
