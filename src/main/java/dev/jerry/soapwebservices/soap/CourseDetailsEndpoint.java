package dev.jerry.soapwebservices.soap;

import com.javacourses.courses.CourseDetails;
import com.javacourses.courses.GetCourseDetailRequest;
import com.javacourses.courses.GetCourseDetailResponse;
import dev.jerry.soapwebservices.soap.bean.Course;
import dev.jerry.soapwebservices.soap.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.Endpoint;


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

        GetCourseDetailResponse response = new GetCourseDetailResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        response.setCourseDetails(courseDetails);
        return response;
    }
}
