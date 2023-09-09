//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.09.09 at 12:28:31 PM EDT 
//


package com.javacourses.courses;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.javacourses.courses package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.javacourses.courses
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCourseDetailRequest }
     * 
     */
    public GetCourseDetailRequest createGetCourseDetailRequest() {
        return new GetCourseDetailRequest();
    }

    /**
     * Create an instance of {@link GetCourseDetailResponse }
     * 
     */
    public GetCourseDetailResponse createGetCourseDetailResponse() {
        return new GetCourseDetailResponse();
    }

    /**
     * Create an instance of {@link CourseDetails }
     * 
     */
    public CourseDetails createCourseDetails() {
        return new CourseDetails();
    }

    /**
     * Create an instance of {@link GetAllCourseDetailRequest }
     * 
     */
    public GetAllCourseDetailRequest createGetAllCourseDetailRequest() {
        return new GetAllCourseDetailRequest();
    }

    /**
     * Create an instance of {@link GetAllCourseDetailResponse }
     * 
     */
    public GetAllCourseDetailResponse createGetAllCourseDetailResponse() {
        return new GetAllCourseDetailResponse();
    }

}
