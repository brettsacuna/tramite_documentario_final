(function () {
    'use-strict';

    angular
        .module('tramiteApp.services', [])
        .factory('documentoFct', documentoFct)
        .factory('usuarioFct', usuarioFct)
        .factory('messageFct', messageFct);

    function documentoFct ($http, $q) {
        return {
            getSecciones : function () {
				var defered = $q.defer();
		        var promise = defered.promise;

		        $http.get('ServletSeccion?opcion=list')
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
			},
            getDisposiciones : function () {
				var defered = $q.defer();
		        var promise = defered.promise;

		        $http.get('ServletDisposicion?opcion=list')
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
			},
            getTipoDocumento : function () {
				var defered = $q.defer();
		        var promise = defered.promise;

		        $http.get('ServletTipo_documento?opcion=list')
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
			},
            getUnidades : function (filtro) {
				var defered = $q.defer();
		        var promise = defered.promise;

		        $http.get('ServletUnidad?opcion=filt&filtro='+filtro)
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
			},
            getClasificaciones : function () {
				var defered = $q.defer();
		        var promise = defered.promise;

		        $http.get('ServletClasificacion?opcion=list')
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
			},
            getAcciones : function () {
				var defered = $q.defer();
		        var promise = defered.promise;

		        $http.get('ServletAccion?opcion=list')
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
			},
            saveDocumento : function (documento) {
                var defered = $q.defer();
		        var promise = defered.promise;

		        $http.post('ServletDocumento', documento)
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
            },
            getDocumentos : function (pagina, limite, desde, hasta, numero_registro, unidad_origen, tipo_documento, destino, bandera, estado) {
				var defered = $q.defer();
		        var promise = defered.promise;

		        $http.get('ServletDocumento?opcion=list&pagina='+pagina+"&limite="+limite+"&bandera="+bandera+"&desde="+desde+"&hasta="+hasta+"&numero_registro="+numero_registro+"&unidad_origen="+unidad_origen+"&tipo_documento="+tipo_documento+"&estado="+estado+"&destino="+destino)
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
			},
            getDecretosDocumento : function (documento) {
                var defered = $q.defer();
		        var promise = defered.promise;

		        $http.get('ServletDocumento?opcion=documento_decreto&documento='+documento)
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
            },
            getDisposicionesDocumento : function (documento) {
                var defered = $q.defer();
		        var promise = defered.promise;

		        $http.get('ServletDocumento?opcion=documento_decreto&documento='+documento)
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
            },
            getEstadosDocumento : function (documento) {
                var defered = $q.defer();
		        var promise = defered.promise;

		        $http.get('ServletDocumento?opcion=documento_situacion&documento='+documento)
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
            },
            saveDecretoDocumento : function (decreto) {
                var defered = $q.defer();
		        var promise = defered.promise;

		        $http.post('ServletDocumento', decreto)
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
            },
            deleteDecretoDocumento : function (decreto) {
                var defered = $q.defer();
		        var promise = defered.promise;

		        $http.get('ServletDocumento?opcion=eliminar_decreto&seccion='+decreto)
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
            },
            saveDisposicionDocumento : function (disposicion) {
                var defered = $q.defer();
		        var promise = defered.promise;

		        $http.post('ServletDocumento', disposicion)
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
            },
            deleteDisposicionDocumento : function (disposicion) {
                var defered = $q.defer();
		        var promise = defered.promise;

		        $http.get('ServletDocumento?opcion=eliminar_disposicion&disposicion='+disposicion)
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
            },
            changeAdjunto : function (adjunto) {
                var defered = $q.defer();
		        var promise = defered.promise;

		        $http.post('ServletDocumento', adjunto)
		            .success(function(data) {
		                defered.resolve(data);
		            })
		            .error(function(err) {
		                defered.reject(err);
		            });

		        return promise;
            }
        };
    }

    function usuarioFct($window, $http) {
        return {
			estaAutenticado: false,
			iniciar_sesion : function (username, password) {
				var data = $.param({
		            usuario: username,
		            contrasena: password,
                    opcion: 'login'
		        });

				return $http.post('ServletUsuario', data).success(function (response) {
					if (response.estado !== 0) {
						$window.sessionStorage.empleado = JSON.stringify(response.usuario);

						return response.estado;
					} else {
						return 0;
					}
				}).error(function (error) {
					return error;
				});
			}
		};
    }

    function messageFct ($uibModal, $log) {
		return {
		    message : function (message, callback, button) {
				var modalMessage = $uibModal.open({
					animation: true,
					templateUrl: 'views/partials/message_tpl_prtl.html',
					controller: 'messageCtrlPrtl as alert',
					size: 'md',
					keyboard: false,
					resolve: {
					  message: function () {
					    return message;
					  },
					  callback : function(){
					    return callback;
					  },
					  button: function(){
					    return button;
					  }
					}
				});

				modalMessage.result.then(function (band) {
					return band;
				}, function () {
					console.log('Modal dismissed at: ' + new Date());
				});
		    }
		};
	}
})();
