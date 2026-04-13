package com.itzel.sicei.Services;


import org.springframework.stereotype.Service;
import com.itzel.sicei.Models.Alumno;
import com.itzel.sicei.Models.Common.ServiceResponse;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AlumnoService {
    private ArrayList<Alumno> alumnos;

    public AlumnoService() {
        this.alumnos = new ArrayList<>(Arrays.asList(
                new Alumno(1, "Blanca I", "Medina Mex", "A22216888", 87.5),
                new Alumno(2, "Carlos A", "Coronado Silva", "A22216878", 90.2),
                new Alumno(3, "Elias", "Rodriguez Gallegos", "A22216890", 87.7),
                new Alumno(4, "Jhonatan j.", "Solis Mezeta", "A22216891", 91.3)
        ));

    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public Alumno getAlumno(int id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId() == id) {
                return alumno;
            }
        }

        return null;
    }

    public ServiceResponse<Alumno> insertAlumno(Alumno alumno) {
        for (Alumno iAlumno : alumnos) {
            if (iAlumno.getId() == alumno.getId()) {
                return ServiceResponse.BadRequest(null);
            }
        }

        if (alumnos.contains(alumno)) {
            return ServiceResponse.BadRequest(null);
        }

        alumnos.add(alumno);
        return ServiceResponse.CreateSuccess(alumno);
    }

    public ServiceResponse<Alumno> updateAlumno (int id, Alumno alumno) {
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getId() == id) {
                alumnos.set(i, alumno);
                return ServiceResponse.Ok(alumno);
            }
        }
        return ServiceResponse.NotFound(null);
    }

    public ServiceResponse<Alumno> deleteAlumno(int id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId() == id) {
                alumnos.remove(alumno);
                return ServiceResponse.Ok(null);
            }
        }
        return ServiceResponse.NotFound(null);
    }
}
