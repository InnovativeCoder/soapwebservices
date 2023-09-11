package dev.jerry.soapwebservices.soap;

import com.javacourses.courses.*;
import dev.jerry.soapwebservices.soap.bean.Course;
import dev.jerry.soapwebservices.soap.exception.CourseNotFoundException;
import dev.jerry.soapwebservices.soap.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import java.util.List;


@Endpoint
public class CourseDetailsEndpoint {

    @Autowired
    CourseDetailsService service;

    @PayloadRoot(namespace ="http://javacourses.com/courses", localPart = "GetCourseDetailRequest")
    @ResponsePayload
    public GetCourseDetailResponse processCourseDetailRequest(
            @RequestPayload
            GetCourseDetailRequest request){
        Course course = service.findById(request.getId());
        if(course==null){
            throw new CourseNotFoundException("Invalid Course Id "+request.getId());
        }
        return mapCourseDetails(course);
    }

    private static GetCourseDetailResponse mapCourseDetails( Course course) {
        GetCourseDetailResponse response = new GetCourseDetailResponse();
        response.setCourseDetails(mapCourse(course));
        return response;
    }

    private GetAllCourseDetailResponse mapAllCourseDetails(List<Course> courses){
        GetAllCourseDetailResponse response = new GetAllCourseDetailResponse();
        for (Course course : courses) {
            CourseDetails mapCourse = mapCourse(course);
            response.getCourseDetails().add(mapCourse);
        }
        return response;
    }

    private static CourseDetails mapCourse(Course course) {
        CourseDetails courseDetails = new CourseDetails();

        courseDetails.setId(course.getId());

        courseDetails.setName(course.getName());

        courseDetails.setDescription(course.getDescription());

        return courseDetails;
    }

    @PayloadRoot(namespace ="http://javacourses.com/courses", localPart = "GetAllCourseDetailRequest")
    @ResponsePayload
    public GetAllCourseDetailResponse processAllCourseDetailRequest(
            @RequestPayload
            GetAllCourseDetailRequest request){
        List<Course> courses = service.findAll();

        return mapAllCourseDetails(courses);
    }

    @PayloadRoot(namespace = "http://javacourses.com/courses", localPart = "DeleteCourseDetailRequest")
    @ResponsePayload
    public DeleteCourseDetailResponse deleteAllCourseDetailsReponse(
            @RequestPayload DeleteCourseDetailRequest request) {
        CourseDetailsService.Status status = service.deleteById(request.getId());
        DeleteCourseDetailResponse response = new DeleteCourseDetailResponse();
        response.setStatus(mapStatus(status));
        return response;
    }

    private Status mapStatus(CourseDetailsService.Status status) {
        if(status==CourseDetailsService.Status.FAILURE){
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }
}
